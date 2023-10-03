let contentMenu = null;
let btnAtras = null;
let btnSiguiente = null;
let waitContent = null;
let insert_image = null;

window.onload = function () {
	contentMenu = document.getElementById("contentMenu");
	btnAtras = document.getElementById("btnAtras");
	btnSiguiente = document.getElementById("btnSiguiente");
	waitContent = document.getElementById("waitContent");
	insert_image = document.getElementById("insertar_image");

	getPokemons("https://pokeapi.co/api/v2/pokemon");
}

async function getPokemons(endpoint) {

	waitContent.style.display = 'block';
	const response = await fetch(endpoint);
	const data = await response.json();


	contentMenu.innerHTML = "";
	for (var i = 0; i < data.results.length; i++) {
		const contenido_menu = document.querySelector("#contentMenu");
		const btnTemp = document.createElement("BUTTON");
		btnTemp.classList.add("col-2", "m-1","btn", "btn-outline-primary");
		btnTemp.setAttribute("id", i);
		btnTemp.textContent = data.results[i].name;
		contenido_menu.appendChild(btnTemp);

		btnTemp.onclick = function(){
			presionarBtn(btnTemp, data.results);
		}

	}

	btnAtras.setAttribute("data-endpoint", data.previous);
	btnSiguiente.setAttribute("data-endpoint", data.next);
	waitContent.style.display = 'none';

}

async function presionarBtn(btnTemp, datos){
	const imagen = document.querySelector(".image");
	if(imagen){
		imagen.remove();
	}
	const response_pokemon = await fetch(datos[parseInt(btnTemp.id)].url);
	const data_pokemon = await response_pokemon.json();
	console.log(data_pokemon.sprites.front_default);
	let imgTemp = `<img class="image" src ="${data_pokemon.sprites.front_default}">`;
	insert_image.innerHTML += imgTemp;
	console.log(data_pokemon.sprites.front_default);
}


function getNext() {
	let endpoint = btnSiguiente.getAttribute("data-endpoint");
	if (endpoint != null) {
		getPokemons(endpoint);
	} else {
		waitContent.style.display = 'none';
	}
}

function getBack() {
	let endpoint = btnAtras.getAttribute("data-endpoint");
	if (endpoint != null) {
		getPokemons(endpoint);
	} else {
		waitContent.style.display = 'none';
	}
}

// document.getElementById(btnTemp).addEventListener("click", getPokemons);