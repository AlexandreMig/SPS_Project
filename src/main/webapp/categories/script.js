async function getDonations(type){
    const responseFromServer = await fetch('/display-servlet');
    const list = await responseFromServer.json();

    const textElement = document.getElementById('result');
    textElement.innerHTML = ''

   for (element of list) {
       if  (type == element.item){
            textElement.appendChild(createUlElement(element));
       }
    }

}

function createUlElement(element){
    console.log(element)
    
    var card=document.createElement('div');
    card.className = "card";

    var name_sec = document.createElement('div');
    var name = document.createElement('h2');
    name.innerHTML = element["name"];
    name_sec.appendChild(name);
    name_sec.className = "card-preview";
    

    var info_sec = document.createElement('div');
    var location = document.createElement('h2');
    location.innerHTML = element["location"];
    var description = document.createElement('h6');
    description.innerHTML = element["item"];
    var phone = document.createElement('button');
    phone.className = "btn";
    phone.innerHTML = element["number"];
    info_sec.appendChild(location);
    info_sec.appendChild(description);
    info_sec.appendChild(phone);
    info_sec.className = "card-info"


    card.appendChild(name_sec);
    card.appendChild(info_sec);
    
    return card;
}

