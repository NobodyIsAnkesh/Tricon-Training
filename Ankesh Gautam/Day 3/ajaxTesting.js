const url = "https://jsonplaceholder.typicode.com/photos";

fetch(url)
    .then((response) => response.json())
    .then(function (jsonData) {
        displayPhotos(jsonData);
    })
    .catch(function (error) {
        alert(error);
    });

function displayPhotos(jsonData) {

    for (var i = 0; i < jsonData.length; i++) {
        var para = document.createElement("IMG");
        para.setAttribute("src", jsonData[i].thumbnailUrl);
        document.getElementById("pic").appendChild(para);
    }
}
