describe("Financial Transfer Scheduler", () => {
  beforeEach(() => {
    cy.visit("http://localhost:8081");
  });

  it("should show the transfer form", () => {
    cy.get("form").should("exist");
  });

  it("should schedule a transfer for today (0 days) with correct fee", () => {
    cy.get('input[placeholder="Source Account (XXXXXXXXXX)"]').type(
      "1234567890"
    );
    cy.get('input[placeholder="Destination Account (XXXXXXXXXX)"]').type(
      "0987654321"
    );
    cy.get('input[placeholder="Amount"]').type("100");

    const today = new Date().toISOString().split("T")[0];
    cy.get('input[type="date"]').type(today);

    cy.get('button[type="submit"]').click();

    cy.get("ul").contains("Fee: $5.50"); // 100 * 2.5% + 3 = 5.50
  });

  it("should schedule a transfer in 5 days (1-10) with fee 12", () => {
    cy.get('input[placeholder="Source Account (XXXXXXXXXX)"]').type(
      "1234567890"
    );
    cy.get('input[placeholder="Destination Account (XXXXXXXXXX)"]').type(
      "0987654321"
    );
    cy.get('input[placeholder="Amount"]').type("200");

    const date = new Date();
    date.setDate(date.getDate() + 5);
    const formatted = date.toISOString().split("T")[0];
    cy.get('input[type="date"]').type(formatted);

    cy.get('button[type="submit"]').click();

    cy.get("ul").contains("Fee: $12");
  });

  it("should schedule a transfer in 15 days (11-20) with 8.2% fee", () => {
    cy.get('input[placeholder="Source Account (XXXXXXXXXX)"]').type(
      "1234567890"
    );
    cy.get('input[placeholder="Destination Account (XXXXXXXXXX)"]').type(
      "0987654321"
    );
    cy.get('input[placeholder="Amount"]').type("150");

    const date = new Date();
    date.setDate(date.getDate() + 15);
    const formatted = date.toISOString().split("T")[0];
    cy.get('input[type="date"]').type(formatted);

    cy.get('button[type="submit"]').click();

    cy.get("ul").contains("Fee: $12.30"); // 150 * 0.082 = 12.3
  });

  it("should show error if date is not applicable for a fee", () => {
    cy.get('input[placeholder="Source Account (XXXXXXXXXX)"]').type(
      "1234567890"
    );
    cy.get('input[placeholder="Destination Account (XXXXXXXXXX)"]').type(
      "0987654321"
    );
    cy.get('input[placeholder="Amount"]').type("100");

    const date = new Date();
    date.setDate(date.getDate() + 60); // beyond 50 days
    const formatted = date.toISOString().split("T")[0];
    cy.get('input[type="date"]').type(formatted);

    cy.get('button[type="submit"]').click();

    cy.get("div").contains(
      "Error scheduling transfer"
    );
  });
});
