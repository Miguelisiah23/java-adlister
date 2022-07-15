<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="pizza-order" method="post">
    <h1>Pizza Order Form</h1>
    <label for="crust">Crust Type</label>
    <select name="crust" id="crust">
        <option value="hand-tossed">Hand Tossed</option>
        <option value="thin">Thin Crust</option>
    </select>
    <br>
    <label for="sauce">Choose a Sauce</label>
    <select id="sauce" name="sauce">
        <option value="tomato">Tomato</option>
        <option value="alfredo">Alfredo</option>
        <option value="marinara">Marinara</option>
    </select>
    <br>
    <label for="cheese">Cheese</label>
    <select id="cheese" name="cheese">
        <option value="light">Light</option>
        <option value="normal">Normal</option>
        <option value="extra-cheese">Extra Cheese</option>
    </select>
    <br>
    <label for="toppings">Toppings</label>
    <ul  id="toppings">
        <li><input name="toppings" type="checkbox" value="pepperoni" id="pep">Pepperoni</li>
        <li><input name="toppings" type="checkbox" value="bacon" id="bacon">Bacon</li>
        <li><input name="toppings" type="checkbox" value="sausage" id="sausage">Sausage</li>
        <li><input name="toppings" type="checkbox" value="mushrooms" id="mush">Mushrooms</li>
        <li><input name="toppings" type="checkbox" value="green peppers" id="grn-pep">Green Peppers</li>
    </ul>
    <label for="address">Enter Address</label>
    <textarea id="address" name="address"></textarea>
<button type="submit">Order Pizza</button>
</form>

</body>
</html>
