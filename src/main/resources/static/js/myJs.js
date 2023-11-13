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


function uploadOnData() {
    const onCells = document.querySelectorAll('#calendarContainer td.on');
    const onData = Array.from(onCells).map(cell => cell.innerText);

    fetch('http://localhost:8080/schedule/api/uploadOnData', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(onData)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}

// 'on' 데이터 업로드 버튼 이벤트 리스너
document.getElementById('uploadOnData').addEventListener('click', uploadOnData);

function downloadTableAsHtml() {
    const table = document.getElementById('calendarContainer').getElementsByTagName('table')[0];
    const tableHtml = table.outerHTML;
    const blob = new Blob([tableHtml], { type: 'text/html' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'table.html';
    link.click();
}

// HTML 파일 다운로드 버튼 이벤트 리스너
document.getElementById('downloadHtml').addEventListener('click', downloadTableAsHtml);