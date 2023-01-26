var rename = document.querySelector(".rename");
rename.addEventListener('click', ()=> {
	document.getElementById("name").style.display = "none";
	document.getElementById('update').style.removeProperty("display")
})