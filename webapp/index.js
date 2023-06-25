function randActivity() {
	let activityDiv = document.getElementById('activities');

	fetch("https://www.boredapi.com/api/activity")
		.then(response => response.json())
		.then(data => {
			activityDiv.innerHTML += `<p> Here's a random activity: ${data.activity} </p>`;
			activityDiv.innerHTML += `<br /><form>`;
			activityDiv.innerHTML += `<input type="button"`
				+ ` value="Get another ${data.type} activity"`
				+ ` onclick="typedActivity(\'${data.type}\')" />`;
			activityDiv.innerHTML += `<form>`;
		})
		.catch(error => alert(error.name + '\n' + error.message));
}

function typedActivity(type) {
	let activityDiv = document.getElementById('activities');

	fetch("https://www.boredapi.com/api/activity?type=" + type)
		.then(response => response.json())
		.then(data => {
			activityDiv.innerHTML += `<p> Here's a random ${data.type} activity: ${data.activity} </p>`;
		})
		.catch(error => alert(error.name + '\n' + error.message));
}
