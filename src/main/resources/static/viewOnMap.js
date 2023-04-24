function initMap() {
	const center = {
		lat: 35.6812,
		lng: 139.7671,
	};

	const map = new google.maps.Map(document.getElementById("map"), {
		zoom: 11,
		center,
		mapId: "DEMO_MAP_ID",
	});

	/**
			   * Google Geocoding. Google Map API에 포함되어 있다.
			   */
	var geocoder = new google.maps.Geocoder();

	// submit 버튼 클릭 이벤트 실행
	document.getElementById('submit').addEventListener('click', function() {
		console.log('submit 버튼 클릭 이벤트 실행');

		// 여기서 실행
		geocodeAddress(geocoder, map);
	});
	document.getElementById('address').addEventListener('keypress', function(e) {
		if (e.key === 'Enter') {
			console.log('submit 버튼 클릭 이벤트 실행');

			// 여기서 실행
			geocodeAddress(geocoder, map);
		}
	});
	makeMarkers(map);
}

if (!localStorage.getItem('tutoPop')) {
	localStorage.setItem('tutoPop', 't');
}
if (localStorage.getItem('tutoPop') == 't') {
	openPop();
}

function openPop() {
	document.getElementById("popup_layer").style.display = "block";

}
function openPopEver() {
	document.getElementById("popup_layer").style.display = "block";
	localStorage.setItem('tutoPop', 't');

}
//팝업 닫기
function closePop() {
	document.getElementById("popup_layer").style.display = "none";
}

function closePopever() {
	document.getElementById("popup_layer").style.display = "none";
	localStorage.setItem('tutoPop', 'f');
}

/**
 * geocodeAddress
 * 
 * 입력한 주소로 맵의 좌표를 바꾼다.
 */
function geocodeAddress(geocoder, resultMap) {
	console.log('geocodeAddress 함수 실행');

	// 주소 설정
	var address = document.getElementById('address').value;

	/**
	 * 입력받은 주소로 좌표에 맵 마커를 찍는다.
	 * 1번째 파라미터 : 주소 등 여러가지. 
	 *      ㄴ 참고 : https://developers.google.com/maps/documentation/javascript/geocoding#GeocodingRequests
	 * 
	 * 2번째 파라미터의 함수
	 *      ㄴ result : 결과값
	 *      ㄴ status : 상태. OK가 나오면 정상.
	 */
	geocoder.geocode({ 'address': address }, function(result, status) {
		console.log(result);
		console.log(status);

		if (status === 'OK') {
			// 맵의 중심 좌표를 설정한다.
			resultMap.setCenter(result[0].geometry.location);
			// 맵의 확대 정도를 설정한다.
			resultMap.setZoom(18);
			// 맵 마커
			var marker = new google.maps.Marker({
				map: resultMap,
				position: result[0].geometry.location
			});

			// 위도
			console.log('위도(latitude) : ' + marker.position.lat());
			// 경도
			console.log('경도(longitude) : ' + marker.position.lng());
			makeMarkers(map);
		} else {
			alert('지오코드가 다음의 이유로 성공하지 못했습니다 : ' + status);
		}
	});
}

function makeMarkers(map) {
	for (const property of properties) {
		const advancedMarkerView = new google.maps.marker.AdvancedMarkerView({
			map,
			content: buildContent(property),
			position: property.position,
			title: property.description,
		});
		const element = advancedMarkerView.element;

		["focus", "pointerenter"].forEach((event) => {
			element.addEventListener(event, () => {
				highlight(advancedMarkerView, property);
			});
		});
		["blur", "pointerleave"].forEach((event) => {
			element.addEventListener(event, () => {
				unhighlight(advancedMarkerView, property);
			});
		});
		advancedMarkerView.addListener("click", (event) => {
			clickhouse();
		});
	}
}

function highlight(markerView, property) {
	markerView.content.classList.add("highlight");
	markerView.element.style.zIndex = 1;
}

function unhighlight(markerView, property) {
	markerView.content.classList.remove("highlight");
	markerView.element.style.zIndex = "";
}

function clickhouse() {
	location.href = 'https://www.naver.com/';
}

function buildContent(property) {
	const content = document.createElement("div");
	content.classList.add("property");
	let pinHtml = `
    <div class="icon">`;
	if (property.type == "buy") {
		pinHtml +=
			`<i aria-hidden="true" class="fa fa-icon fa-yen-sign buy" title="For sale"></i>
      <span class="fa-sr-only">${property.type}</span>
    </div>`;
	} else {
		pinHtml += `<i aria-hidden="true" class="fa fa-icon fa-calendar-days rent" title="For rent"></i>
      <span class="fa-sr-only">${property.type}</span>
    </div>`;
	}
	pinHtml += `<div class="details">
        <div class="price">${property.price}</div>
        <div class="address">${property.address}</div>
        <div class="features">
        <div>
            <i aria-hidden="true" class="fa fa-bed fa-lg structure" title="structure"></i>
            <span class="fa-sr-only">structure</span>
            <span>${property.structure}</span>
        </div>
        <div>
        <i aria-hidden="true" class="fa fa-ruler fa-lg size" title="size"></i>
        <span class="fa-sr-only">size</span>
        <span>${property.size} m<sup>2</sup></span>
          </div>
        </div>
        <div class='condition'>       
  `;

	if (property.bathroom == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-bath fa-lg bathroom" title="Separated baths"></i>
                <span class="fa-sr-only">bathroom</span>
            </div>            
    `;
	}

	if (property.over2f == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-square-2 fa-lg over2f" title="Second floor or higher"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	if (property.parking == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-car fa-lg parking" title="Parking available"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	if (property.washer == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-washer fa-lg washer" title="Washing machine in house"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	if (property.aircon == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-air-conditioner fa-lg aircon" title="Air conditioner in house"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	if (property.pet == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-dog fa-lg pet" title="Can breed pets"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	if (property.autolock == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-lock-a fa-lg autolock" title="Includes a digital door lock"></i>
                <span class="fa-sr-only">2ndfloor</span>
            </div>             
    `;
	}

	pinHtml += `</div><div class='convenience'>`;

	if (property.bus == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-bus fa-lg bus" title="Close to bus station"></i>
                <span class="fa-sr-only">bus</span>
            </div>             
    `;
	}

	if (property.subway == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-train-subway fa-lg subway" title="close to subway station"></i>
                <span class="fa-sr-only">subway </span>
            </div>             
    `;
	}

	if (property.hospital == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-stethoscope   fa-lg hospital" title="Close to hospital"></i>
                <span class="fa-sr-only">hospital</span>
            </div>             
    `;
	}

	if (property.convini == true) {
		pinHtml += `
            <div id='condition'>
                <i aria-hidden="true" class="fa fa-store fa-lg convini" title="Close to convenience store"></i>
                <span class="fa-sr-only">convini</span>
            </div>             
    `;
	}

	pinHtml += `</div></div>`;
	content.innerHTML = pinHtml;
	return content;
}

const properties = [
	{
		address: "大阪市中央区南船場4-4-21",
		description: "¥250000 N2",
		price: "CAL CO,.LTD",
		type: "buy",
		structure: "1LDK",
		size: 300,
		bathroom: true,
		over2f: true,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 34.6758264,
			lng: 135.4998947,
		},
	},
	{
		address: "東京都 千代田区 神田富山町22",
		description: "¥250000",
		price: "株式会社ネクスチャ",
		type: "rent",
		structure: "2LDK",
		size: 200,
		bathroom: false,
		over2f: false,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 35.6935207,
			lng: 139.7730301,
		},
	},
	{
		address: "東京都千代田区神田小川町2-12 小川町進興ビル",
		description: "¥320000 N1 정처기",
		price: "チームラボ",
		type: "buy",
		structure: "1LDK",
		size: 200,
		bathroom: true,
		over2f: true,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 35.6951588,
			lng: 139.76481,
		},
	},
	{
		address: "中央区日本橋堀留町２－３－１４",
		description: "¥250000 N2 정처기",
		price: "株式会社SoftBay",
		type: "rent",
		structure: "2LDK",
		size: 600,
		bathroom: true,
		over2f: true,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 35.688747,
			lng: 139.7808054,
		},
	},
	{
		address: "東京都新宿区新宿1-36-7",
		description: "¥250000",
		price: "¥250000",
		type: "buy",
		structure: "2LDK",
		size: 100,
		bathroom: true,
		over2f: true,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 35.6907471,
			lng: 139.7102648,
		},
	},
	{
		address: "東京都港区南青山3-1-30",
		description: "¥235000 N2 정처기",
		price: "株式会社パソナテック",
		type: "buy",
		structure: "1LDK",
		size: 500,
		bathroom: true,
		over2f: true,
		parking: true,
		washer: true,
		aircon: true,
		pet: true,
		autolock: true,
		bus: true,
		subway: true,
		convini: true,
		hospital: true,
		position: {
			lat: 35.6677398,
			lng: 139.7157978,
		},
	},
];


