<template>
  <div id="app" class="container py-5">
    <header class="text-center mb-5">
      <h1 class="text-primary">💸 Financial Transfer Scheduler</h1>
      <p class="text-muted">
        Schedule and track your financial transfers easily
      </p>
    </header>
    <main class="d-flex flex-column gap-4">
      <TransferForm @transfer-created="reloadTransfers" />
      <TransferList ref="transferList" />
    </main>
  </div>
</template>

<script>
import TransferForm from "./components/TransferForm.vue";
import TransferList from "./components/TransferList.vue";

export default {
  name: "App",
  components: { TransferForm, TransferList },
  methods: {
    reloadTransfers() {
      this.$refs.transferList.fetchTransfers();
    },
  },
};
</script>

<style>
body {
  background-color: #f8f9fa;
  font-family: Arial, sans-serif;
}
</style>
