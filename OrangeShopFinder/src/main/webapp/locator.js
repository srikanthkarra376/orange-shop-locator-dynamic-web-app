var map, infoWindow;

window.onload = function() {
  let lat1 = Number(document.getElementById("lat1").innerHTML);
  let lat2 = Number(document.getElementById("lat2").innerHTML);
  let lng1 = Number(document.getElementById("lng1").innerHTML);
  let lng2 = Number(document.getElementById("lng2").innerHTML);

  initMap(lat1, lat2, lng1, lng2);
};

function initMap(lat1, lat2, lng1, lng2) {
  map = new google.maps.Map(document.getElementById("map-view"), {
    center: { lat: -34.397, lng: 150.644 },
    zoom: 10
  });

  console.log(`${lat1}${lat2}${lng1}${lng2}`);
  infoWindow = new google.maps.InfoWindow();

  // Try HTML5 geolocation.
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      function(position) {
        var pos = {
          lat: lat1,
          lng: lng1
        };
        var pos2 = {
          lat: lat2,
          lng: lng2
        };
        var marker = new google.maps.Marker({
        	animation:google.maps.Animation.BOUNCE,
        	label: {text: "Orange Store", color: "#fa6304" },
        
          position: pos
        });
        var marker2 = new google.maps.Marker({
        	label: {text: "Your Location", color: "#fa6304" },
          position: pos2
        });
        new google.maps.event.addListener(marker, "click", function() {
          //var pos = map.getZoom();
          map.setZoom(12);
          map.setCenter(marker.getPosition());
        });

        //infoWindow.setPosition(pos);

        //infoWindow.open(map);
        marker.setMap(map);
        marker2.setMap(map);
        var myTrip = [pos, pos2];
        var flightPath = new google.maps.Polyline({
          path: myTrip,
          geodesic: true,
          strokeColor: "#FF0000",
          strokeOpacity: 1.5,
          strokeWeight: 2
        });
        

        
        map.setCenter(pos);
        map.setZoom(12);
        flightPath.setMap(map);
        map.setCenter(flightPath);
      },

      function() {
        handleLocationError(true, map.getCenter());
      }
    );
  } else {
    // Browser doesn't support Geolocation
    handleLocationError(false, infoWindow, map.getCenter());
  }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
  infoWindow.setPosition(pos);
  infoWindow.setContent(
    browserHasGeolocation
      ? "Error: The Geolocation service failed."
      : "Error: Your browser doesn't support geolocation."
  );
  infoWindow.open(map);
}
