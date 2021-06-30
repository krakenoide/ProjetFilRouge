let navigation=document.querySelector("ul");

window.addEventListener("scroll", () => {
	if (window.scrollY>30){
		navigation.classList.add("nav-links-animation");
	} else {
		navigation.classList.remove("nav-links-animation");
	}
});