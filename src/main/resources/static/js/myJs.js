document.getElementById('loadCalendarData').addEventListener('click', function() {

    const year = document.getElementById('year').value;
    const month = document.getElementById('month').value;

    if (year && month) {
    fetch(`http://localhost:8080/schedule/api/calendar?year=${year}&month=${month}`) // 실제 API 엔드포인트로 변경해야 합니다.
        .then(response => response.json())
        .then(calendarNestedList => {
            const container = document.getElementById('calendarContainer');
            container.innerHTML = ''; // 기존 데이터 초기화

            if (calendarNestedList) {
                const table = document.createElement('table');
                const headerRow = `<tr>
                    <th>일</th>
                    <th>월</th>
                    <th>화</th>
                    <th>수</th>
                    <th>목</th>
                    <th>금</th>
                    <th>토</th>
                </tr>`;
                table.innerHTML = headerRow;

                calendarNestedList.forEach(calendarList => {
                    const row = document.createElement('tr');
                    calendarList.forEach(calendarDay => {
                        const cell = document.createElement('td');
                        cell.textContent = calendarDay;

                        // 클릭 이벤트 리스너 추가
                        cell.addEventListener('click', function() {
                            this.classList.toggle('on');
                            updateOnCount(); // on 상태인 요소 수 업데이트
                        });

                        row.appendChild(cell);
                    });
                    table.appendChild(row);
                });

                container.appendChild(table);
            }
        })
        .catch(error => console.error('Error:', error));
        } else {
            alert('연도와 월을 모두 입력해주세요.');
        }
});

// on 상태인 td 요소들의 수를 업데이트하는 함수
function updateOnCount() {
    const onElementsCount = document.querySelectorAll('#calendarContainer .on').length;
    document.getElementById('onCountDisplay').textContent = `On 상태의 요소 수: ${onElementsCount}`;
}

// Reset 버튼 이벤트 리스너
document.getElementById('resetOnState').addEventListener('click', function() {
    // 모든 td 요소에서 'on' 클래스 제거
    const allTdElements = document.querySelectorAll('#calendarContainer td');
    allTdElements.forEach(td => {
        td.classList.remove('on');
    });

    // on 상태의 요소 수 업데이트
    updateOnCount();
});


function insertTableHtml() {
    const table = document.getElementById('calendarContainer').getElementsByTagName('table')[0];
    const tableHtml = table.outerHTML; // 테이블의 HTML 추출
    const year = document.getElementById('year').value;
    const month = document.getElementById('month').value;
    const mId = document.getElementById('mId').value;
    const key1 = document.getElementById('keyword1').value;
    const key2 = document.getElementById('keyword2').value;
    const key3 = document.getElementById('keyword3').value;


    fetch('http://localhost:8080/schedule/api/insertTableHtml', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({  html: tableHtml,
                                year: year,
                                month: month,
                                mId: mId,
                                key1: key1,
                                key2: key2,
                                key3: key3 })
    })
    .then(response => {
        if (response.ok) {
            // 요청이 성공적으로 처리되었을 때의 처리
            console.log('데이터 전송 성공');
        } else {
            // 요청이 실패한 경우의 처리
            console.error('데이터 전송 실패');
        }
    })
    .catch(error => {
        // 네트워크 오류 등의 처리
        console.error('데이터 전송 중 오류 발생:', error);
    });
}

// HTML 업로드 버튼 이벤트 리스너
document.getElementById('insertHtml').addEventListener('click', insertTableHtml);

//function downloadTableAsHtml() {
//    const table = document.getElementById('calendarContainer').getElementsByTagName('table')[0];
//    const tableHtml = table.outerHTML;
//    const blob = new Blob([tableHtml], { type: 'text/html' });
//    const link = document.createElement('a');
//    link.href = URL.createObjectURL(blob);
//    link.download = 'table.html';
//    link.click();
//}
//
//// HTML 파일 다운로드 버튼 이벤트 리스너
//document.getElementById('downloadHtml').addEventListener('click', downloadTableAsHtml);


function getHtmlTable() {
    const year = document.getElementById('year').value;
    const month = document.getElementById('month').value;
    const mId = document.getElementById('mId').value;

    fetch('/schedule/api/getHtmlTable', {
         method: 'POST',
         headers: {
                'Content-Type': 'application/json',
         },
         body: JSON.stringify({
              year: year,
              month: month,
              mId: mId})
         })
         .then(response => response.text())
         .then(htmlTable => {
         // HTML 데이터를 tableContainer 내에 삽입
            var tableContainer = document.getElementById("tableContainer");
            tableContainer.innerHTML = htmlTable;
         })
         .catch(error => console.error('HTML 데이터를 가져오는 중 오류 발생:', error));
}

document.getElementById('getHtmlTable').addEventListener('click', getHtmlTable);