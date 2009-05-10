/*
 * bullshitcharts - A Bullshit Chart Generator
 *
 * Copyright (C) 2009 Richard "Shred" Körber
 *   http://bullshitcharts.shredzone.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

var imgcnt = 0;

function showElement(id) {
	document.getElementById(id).style.display = "table-row";
}

function hideElement(id) {
	document.getElementById(id).style.display = "none";
}

function expose(id) {
	switch (id) {
	case 0:
		showElement("slices");
		hideElement("resolution");
		hideElement("amplitude");
		hideElement("axis");
		break;

	case 1:
		hideElement("slices");
		hideElement("resolution");
		hideElement("amplitude");
		hideElement("axis");
		break;

	case 2:
	case 3:
		hideElement("slices");
		showElement("resolution");
		showElement("amplitude");
		showElement("axis");
		break;
	}
}

function getSelectedValue(radio) {
	for ( var ix = 0; ix < radio.length; ix++) {
		if (radio[ix].checked) {
			return radio[ix].value;
		}
	}
	return null;
}

function generateChart() {
	var f = document.paramform;
	var imgurl;

	switch (getSelectedValue(f.mode)) {
	case "pie":
		imgurl = "chart/pie.png?";
		imgurl += "cnt=" + (imgcnt++);
		imgurl += "&c1=" + encodeURIComponent(f.c1.value);
		imgurl += "&c2=" + encodeURIComponent(f.c2.value);
		imgurl += "&c3=" + encodeURIComponent(f.c3.value);
		imgurl += "&c4=" + encodeURIComponent(f.c4.value);
		imgurl += "&c5=" + encodeURIComponent(f.c5.value);
		break;

	case "agree":
		imgurl = "chart/agree.png?";
		imgurl += "cnt=" + (imgcnt++);
		break;

	case "line":
		imgurl = "chart/line.png?";
		imgurl += "cnt=" + (imgcnt++);
		imgurl += "&r=" + getSelectedValue(f.r);
		imgurl += "&a=" + getSelectedValue(f.a);
		imgurl += "&x=" + encodeURIComponent(f.x.value);
		imgurl += "&y=" + encodeURIComponent(f.y.value);
		break;

	case "bar":
		imgurl = "chart/bar.png?";
		imgurl += "cnt=" + (imgcnt++);
		imgurl += "&r=" + getSelectedValue(f.r);
		imgurl += "&a=" + getSelectedValue(f.a);
		imgurl += "&x=" + encodeURIComponent(f.x.value);
		imgurl += "&y=" + encodeURIComponent(f.y.value);
		break;
	}

	if (imgurl) {
		imgurl += "&title=" + encodeURIComponent(f.title.value);
		imgurl += "&t=" + getSelectedValue(f.t);

		document.getElementById("chart").src = imgurl;
	}

    return false;
}
