<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Orange App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" media="screen" href="locator.css" />
    
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC08q105oDXp_Xw4Wy_nk57GhVDTvefMxI">
    </script>
    <script src="locator.js"></script>
  </head>
  <body>

    <h1>ORANGE STORE LOCATOR</h1>
    <div class="container">
      <section class="top">
        
      <div>
        <p> Nearest Store geo-coordinates: 
        <span id="lat1" ><c:out value="${destination_lat}"/></span>,
        <span id="lng1" ><c:out value="${destination_lng}"/></span></p>
        <p>
         Your geo-coordinates:
        <span  id="lat2" ><c:out value="${user_lat}"/></span>,
        <span  id="lng2" ><c:out value="${user_lng}"/></span>
        </p>
      </div>
      <p>Nearest Orange Store from your location:<span class="data"><c:out value="${destination_address}"/> </span> </p>
      <p>Distance from your location to store(kms): <span class="data"><c:out value="${distance}"/> </span></p>
      <p>You have choosen : <span class="data"><c:out value="${mobile}"/>  </span></p>
      <p>Available stack: <span class="data"><c:out value="${available}"/> </span></p>
      </section>
      
      <section class="bottom">
        <div class="view-location">
          <div id="printlocation">

          </div>
        </div>
        <div class="map">
          <div id="map-view">
          
            
          </div>
        </div>
      </section>
    </div>
    </script>
    
  </body>
</html>
