var submitButton = document.querySelector("#submitButton");
var username = document.querySelector("#username");
var eyeIcons = document.querySelectorAll('.fa-eye')
eyeIcons
eyeIcons.forEach((eyeIcon) => {
	eyeIcon.addEventListener('click', () => {
		if(eyeIcon.classList.contains('fa-eye')){
			eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')
			if(eyeIcon.getAttribute('id') === 'passwordEyeIcon'){
			document.querySelector("#password").type = 'text'
			} else{
				document.querySelector('#confirmPassword').type = 'text'
			}
		} else{
			eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
			if(eyeIcon.getAttribute('id') === 'passwordEyeIcon'){
			document.querySelector("#password").type = 'password'
			} else{
				document.querySelector('#confirmPassword').type = 'password'
			}
		}
	})
})

username.addEventListener('blur', () => {
	var user = {
			"username" : username.value,
		};
	let responseEntity = fetch(`/users/exists`, {
			method: 'POST',
			headers: {
				"Content-Type" : "application/json"
				
			},
			body: JSON.stringify(user)
		})
		responseEntity.then((responseEntity) => responseEntity.json)
		.then((data) => {
			if(data === true){
				// user already exist
				alert("Oops, this username  already exists")
			}
		})
		.catch(error => (console.log(error)))
		
})