# SuperMarket Payment Flow

## Objective
This program demonstrates **interface-based dependency injection** using different modes of payment.

---

## Steps

1. Create a **Customer** class with the following fields:
   - `customerName`
   - `amount`
   - `modeOfPayment` (to be injected)

2. Create an **interface** named `ModeOfPayment` with a method:
   - `modeOfPayment()`

3. Create three classes that implement the `ModeOfPayment` interface:
   - `CardPayment`
   - `UpiPayment`
   - `DefaultPayment`

4. In the **Customer** class, write a method to **generate the bill** that prints:
   - Customer name
   - Amount
   - Mode of payment

5. Add a **"Thank You" message** at the end of the bill.

6. Create a **main class** named `SuperMarket`:
   - Create an object of `ModeOfPayment`
   - Inject the `ModeOfPayment` into the `Customer`
   - Print all customer and payment details

---

## Notes
- This design follows **loose coupling** using interfaces.
- New payment modes can be added without modifying the `Customer` class.
- This approach is commonly used in **Spring / Spring Boot applications**.
