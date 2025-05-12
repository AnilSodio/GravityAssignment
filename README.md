Postman Testing Steps
============================================
Step 1: Open Postman
Launch the Postman app on your computer.

Step 2: Create a New Request
Click “+ New” tab to create a new request.

Set the method to POST.

In the URL field, enter:
http://localhost:8080/api/sale/calculate

Step 3: Set Headers
Click the "Headers" tab and add the following:

    Key	            Value
Content-Type	application/json

Step 4: Add JSON Body
Click the "Body" tab → select “raw” → choose JSON from the dropdown.

Paste this example:

{
  "prices": [10, 20, 30, 40, 50, 60]
}

Step 5: Send the Request
Click “Send”.

Step 6: Review the Response
You should see a JSON response like:

{
  "payableItems": [60, 40, 20],
  "freeItems": [50, 30, 10]
}