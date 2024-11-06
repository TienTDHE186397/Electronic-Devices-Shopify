
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 700px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="file"],
        input[type="date"],
        input[type="number"],
        textarea,
        select {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
        }

        button {
            padding: 10px 15px;
            border: none;
            background: #28a745;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }

    </style>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Slider</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

        <div class="container">
            <h2>Add New Slider</h2>
            <form action="addSlider" method="post"  enctype="multipart/form-data">
                
                <label for="slidertittle">Slider Tittle:</label>
                <input type="text" id="blogTitle" name="slidertittle" placeholder="Tittle Slider....." required>
                <div class="form-group">
                    <label>Slider Image: </label>
                    <input type="file" class="form-control" id="centeredInput" accept=".jpg" name="sliderimage">
                    <br/>
                    <label>Slider Video: </label>
                    <input type="file" class="form-control" id="centeredInput" accept=".mp4" name="slidervideo">
                </div>

                <label for="sliderbacklink">Slider Backlink:</label>
                <input type="text" id="blogTitle" name="sliderbacklink" placeholder="Tittle Backlink....." required>

                <label for="slidernote">Slider Note:</label>
                <input type="text" id="blogTitle" name="slidernote" placeholder="Note Slider.....">

                <label for="sliderstatus">Slider Status:</label>
                <select id="blogStatus" name="sliderstatus" required>
                    <option value="Published">Published</option>
                    <option value="Hided">Hided</option>
                </select>

                <button type="submit">Add Slide</button>
            </form>
        </div>

    </body>



</html>
