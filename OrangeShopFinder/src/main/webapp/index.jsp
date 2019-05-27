<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Orange App</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" type="text/css" media="screen" href="index.css" />
  <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC08q105oDXp_Xw4Wy_nk57GhVDTvefMxI&call=getLocation">
    </script>
  <script src="index.js"></script>
</head>

<body>
  <div class="container">
    <section class="top">
      <div class="getlocation">
        <button onclick="getLocation()">getMyLocation</button>
      </div>
     
    </section>
   <form method="post" action="OrangeLocatorServlet">
      Latitude: <input type="text" id="lat" name="lat"><br>
      Longitude: <input type="text" id="lng" name="lng"><br>
      Please select a model: <select  name="mobile_name">
        <option value="sunusng">sunusng</option>
        <option value="ipom">ipom</option>
        <option value="weiwei">weiwei</option>
       </select><br>
      <input type="submit" value="submit">
    </form>
    </form>
   
  </div>
  </script>

</body>

</html>