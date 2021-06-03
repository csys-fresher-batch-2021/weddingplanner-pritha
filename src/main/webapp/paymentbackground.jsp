<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-payment background</title>
</head>
<title>The Ken Burns Effect in CSS</title>
    <style>
        h1 {
            font-family: monospace;
            font-size: 2.1em;
            color: #3399FF;
        }
        body {
            padding: 10px;
            background-color: #F4F4F4;
        }
        #imageContainer {
            background-color: #333;
            width: 450px;
            height: 300px;
            overflow: hidden;
            border: 2px #333 solid;
        }
        #imageContainer img {
  animation: kenburns 20s infinite;
}
        @keyframes kenburns {
    0% {
      opacity: 0;
    }
    5% {
      opacity: 1;
    }
    95% {
        transform: scale3d(1.5, 1.5, 1.5) translate3d(-190px, -120px, 0px);
        animation-timing-function: ease-in;
        opacity: 1;
    }
    100% {
        transform: scale3d(2, 2, 2) translate3d(-170px, -100px, 0px);
        opacity: 0;
    }
}
    </style>
</head>
 
<body>
 
    <h1>The Ken Burns Effect in CSS</h1>
 
    <div id="imageContainer">
        <img src="assets/img/formal.jpg">
    </div>
 
    <script src="//www.kirupa.com/prefixfree.min.js"></script>
</body>
 
</html>

