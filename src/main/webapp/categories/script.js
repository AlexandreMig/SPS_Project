async function getDonations(){
    const responseFromServer = await fetch('/display-servlet');
    const list = await responseFromServer.json();

    const textElement = document.getElementById('general');
    textElement.innerHTML = list.name;

   for (element of list) {
        textElement.innerHTML = element.name;
    }

}

