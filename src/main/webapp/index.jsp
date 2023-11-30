<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Product Page</title>
     <style> 
        body {
            font-family: 'Arial', sans-serif;
            background-color: #fafafa; 
            color: #333;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
           /* background: linear-gradient(45deg, rgb(39, 77, 104) 5%, rgb(83, 65, 118) 77%);*/
        }

        #headline {
            color: black; 
            text-align: center; 
            margin-bottom: 20px; 
        }

        form {
            margin: auto;
            width: 30%;
            background-color: #fff; 
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); 
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333; 
        }

        input {
            outline: none;
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ddd;  
            border-radius: 4px;
        }

        input:hover{
            border: 1px solid green;
        }

        button {
            background-color: gainsboro; 
            color: black;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            /* margin-left: 35%; */
        }

        button:hover {
            background-color: lightgreen;
        }
        #refresh{
            background-color: white; 
            color: #09ac19;
            padding: 10px;
            border: 1px solid #09ac19;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-left:10%;
        }
        #refresh:hover{
            background-color: #09ac19; 
            color: #fff;
        }
    </style>
</head>
<body>
<br>
<br>
<br>
    <h1 id="headline">Enter Product Details : </h1>
    <form  action="save">
        <label for="id">ID : </label><input type="text" name="id" id="id" placeholder="Enter Id" required="required">
        <label for="name">Name : </label><input type="text" name="name" id="name" placeholder="Enter Name" required="required">
        <label for="price">Price : </label><input type="text" name="price" id="price" placeholder="Enter Price" required="required">
        <label for="quantity">Quantity : </label><input type="text" name="quantity" id="quantity" placeholder="Enter Quantity" required="required">
        <button type="submit">Save Product</button>
        <a href="fetchall" style="float: right;"> <button type="button">View All Products</button> </a>
        
    </form>
</body>
</html>
