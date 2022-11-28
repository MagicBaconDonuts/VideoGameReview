var editIcon = document.querySelector(".fa-pen-to-square")
var edit2Icon = document.getElementById('editIcon2')
var elementForm = document.getElementsByClassName("form")

editIcon.addEventListener('click', () => {
		document.getElementById('title').style.display = "none";
		document.getElementById('description').style.display = "none";
		document.getElementById('rating').style.display = "none";
		document.getElementById('complete').style.display = "none";
		document.getElementById('delete').style.display = "none";
		document.getElementById('update').style.removeProperty("display")
})	
edit2Icon.addEventListener('click', () => {
	document.getElementById('title').style.removeProperty("display")
	document.getElementById('update').style.display = "none";
	document.getElementById('description').style.removeProperty("display")
	document.getElementById('rating').style.removeProperty("display")
	document.getElementById('complete').style.removeProperty("display")
	document.getElementById('delete').style.removeProperty("display")
	
})