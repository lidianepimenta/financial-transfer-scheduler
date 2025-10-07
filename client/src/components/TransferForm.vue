<template>
  <div class="card p-4 shadow-lg rounded-4">
    <h2 class="mb-4 text-primary">📤 Schedule Transfer</h2>
    <form @submit.prevent="submitTransfer" class="d-flex flex-column gap-3">
      <input
        v-model="transferData.sourceAccount"
        class="form-control rounded-3"
        placeholder="Source Account (XXXXXXXXXX)"
        maxlength="10"
        :class="{ 'is-invalid': sourceError }"
        @keypress="onlyNumbers($event)"
        required
      />
      <div class="invalid-feedback">{{ sourceError }}</div>
      <input
        v-model="transferData.destinationAccount"
        class="form-control rounded-3"
        placeholder="Destination Account (XXXXXXXXXX)"
        maxlength="10"
        :class="{ 'is-invalid': destError }"
        @keypress="onlyNumbers($event)"
        required
      />
      <div class="invalid-feedback">{{ destError }}</div>
      <input
        v-model.number="transferData.amount"
        type="number"
        class="form-control rounded-3"
        placeholder="Amount"
        min="0.01"
        step="0.01"
        required
      />
      <input
        type="date"
        v-model="transferData.transferDate"
        class="form-control rounded-3"
        required
      />
      <button type="submit" class="btn btn-success rounded-pill">
        <i class="fa fa-paper-plane me-2"></i> Schedule
      </button>
    </form>
    <div
      v-if="error"
      class="alert alert-danger mt-3 d-flex align-items-center"
      role="alert"
    >
      <i class="fa fa-exclamation-triangle me-2"></i> {{ error }}
    </div>
    <div
      v-if="success"
      class="alert alert-success mt-3 d-flex align-items-center"
      role="alert"
    >
      <i class="fa fa-check-circle me-2"></i> Transfer scheduled successfully!
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      transferData: {
        sourceAccount: "",
        destinationAccount: "",
        amount: 0,
        transferDate: "",
      },
      error: "",
      success: false,
      sourceError: "",
      destError: "",
    };
  },
  methods: {
    async submitTransfer() {
      this.error = "";
      this.success = false;
      if (this.sourceError || this.destError) return;
      if (
        this.transferData.sourceAccount === this.transferData.destinationAccount
      ) {
        this.error = "Source and destination accounts must be different.";
        return;
      }
      try {
        await axios.post("http://localhost:8080/transfers", this.transferData);
        this.success = true;
        this.transferData = {
          sourceAccount: "",
          destinationAccount: "",
          amount: 0,
          transferDate: "",
        };
        this.$emit("transfer-created");
      } catch (e) {
        if (e.response && e.response.data && e.response.data.message) {
          if (e.response.data.message.includes("Fee not applicable")) {
            this.error =
              "Transfer not allowed: no applicable fee for the selected date.";
          } else {
            this.error = e.response.data.message;
          }
        } else {
          this.error = "Error scheduling transfer";
        }
      }
    },
    onlyNumbers(e) {
      const char = String.fromCharCode(e.keyCode || e.which);
      if (!/[0-9]/.test(char)) {
        e.preventDefault();
      }
    },
  },
};
</script>
<style scoped>
.invalid-feedback {
  display: block;
}
</style>
