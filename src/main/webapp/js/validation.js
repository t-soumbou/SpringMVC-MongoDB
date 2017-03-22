
function seeForeign(foreignName) {
	var tab, foreignValue;
	tab = document.getElementsByClassName(foreignName);
	foreignValue = tab[0].value;
	alert(foreignValue);
	href = tab[1].href;
	tab[1].href = tab[1].href.substring(0, href.lastIndexOf("/")) + "/"
			+ foreignValue;

}

