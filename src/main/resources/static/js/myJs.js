//function insertTableHtml() {
//    const table = document.getElementById('calendarContainer').getElementsByTagName('table')[0];
//    const tableHtml = table.outerHTML; // 테이블의 HTML 추출
//    const year = document.getElementById('year').value;
//    const month = document.getElementById('month').value;
//    const mId = document.getElementById('mId').value;
//    const key1 = document.getElementById('keyword1').value;
//    const key2 = document.getElementById('keyword2').value;
//    const key3 = document.getElementById('keyword3').value;
//
//
//    fetch('http://localhost:8080/schedule/api/insertTableHtml', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json',
//        },
//        body: JSON.stringify({  html: tableHtml,
//                                year: year,
//                                month: month,
//                                mId: mId,
//                                key1: key1,
//                                key2: key2,
//                                key3: key3 })
//    })
//    .then(response => {
//        if (response.ok) {
//            // 요청이 성공적으로 처리되었을 때의 처리
//            console.log('데이터 전송 성공');
//        } else {
//            // 요청이 실패한 경우의 처리
//            console.error('데이터 전송 실패');
//        }
//    })
//    .catch(error => {
//        // 네트워크 오류 등의 처리
//        console.error('데이터 전송 중 오류 발생:', error);
//    });
//}
//
//// HTML 업로드 버튼 이벤트 리스너
//document.getElementById('insertHtml').addEventListener('click', insertTableHtml);
//
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
//
//
//function getHtmlTable() {
//    const year = document.getElementById('year').value;
//    const month = document.getElementById('month').value;
//    const mId = document.getElementById('mId').value;
//
//    fetch('/schedule/api/getHtmlTable', {
//         method: 'POST',
//         headers: {
//                'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({
//              year: year,
//              month: month,
//              mId: mId})
//         })
//         .then(response => response.text())
//         .then(htmlTable => {
//         // HTML 데이터를 tableContainer 내에 삽입
//            var tableContainer = document.getElementById("tableContainer");
//            tableContainer.innerHTML = htmlTable;
//         })
//         .catch(error => console.error('HTML 데이터를 가져오는 중 오류 발생:', error));
//}
//
//document.getElementById('getHtmlTable').addEventListener('click', getHtmlTable);

