<template>
  <div class="card p-4 shadow-lg rounded-4">
    <h2 class="mb-4 text-secondary">📜 Transfer History</h2>

    <!-- 🔍 Filtros -->
    <div class="row mb-3 g-2">
      <div class="col-md-6">
        <input
          v-model="searchTerm"
          type="text"
          class="form-control"
          placeholder="Search by account..."
        />
      </div>
      <div class="col-md-6">
        <input
          v-model="filterDate"
          type="date"
          class="form-control"
          placeholder="Filter by transfer date"
        />
      </div>
    </div>

    <!-- 📋 Lista de transferências -->
    <transition-group name="fade" tag="ul" class="list-group">
      <li
        v-for="t in filteredTransfers"
        :key="t.id"
        class="list-group-item d-flex justify-content-between align-items-center rounded-3 mb-2 shadow-sm"
      >
        <div>
          <strong>{{ t.sourceAccount }} → {{ t.destinationAccount }}</strong>
          <br />
          Amount: <span class="text-success">R${{ t.amount.toFixed(2) }}</span> |
          Fee: <span class="text-warning">R${{ t.fee.toFixed(2) }}</span> <br />
          Transfer Date: {{ t.transferDate }} | Scheduled:
          {{ t.schedulingDate }}
        </div>
        <i class="fa fa-check-circle text-success fs-4"></i>
      </li>
    </transition-group>

    <div v-if="filteredTransfers.length === 0" class="alert alert-info mt-3">
      No transfers found for the given criteria.
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      transfers: [],
      searchTerm: "",
      filterDate: "",
    };
  },
  computed: {
    filteredTransfers() {
      const search = this.searchTerm.toLowerCase();
      const date = this.filterDate;

      return this.transfers.filter((t) => {
        const matchesAccount =
          t.sourceAccount.toLowerCase().includes(search) ||
          t.destinationAccount.toLowerCase().includes(search);

        const matchesDate = !date || t.transferDate === date;

        return matchesAccount && matchesDate;
      });
    },
  },
  methods: {
    async fetchTransfers() {
      try {
        const response = await axios.get("http://localhost:8080/transfers");
        this.transfers = response.data;
      } catch (err) {
        console.error(err);
      }
    },
  },
  async created() {
    await this.fetchTransfers();
  },
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: all 0.5s ease;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}
.fade-enter-to,
.fade-leave-from {
  opacity: 1;
  transform: translateY(0);
}
</style>
