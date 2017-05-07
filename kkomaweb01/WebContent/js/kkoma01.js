/**
 * 꼬마web 전용 자바스크립트
 */

//날짜점검
function dateCheck(no){
    var form = document.search;
    var startDateObj = form["srch_date_from"+no];
    var endDateObj = form["srch_date_to"+no];
    var startDate = startDateObj.value.replace( /\-/g,'' );
    var endDate = endDateObj.value.replace( /\-/g,'' );
    
    if(startDate.length != 8 || endDate.length != 8){
        alert("날짜가 정상적으로 입력 되지 않았습니다.");
        startDateObj.focus();
        return false;
    }

    if(startDate.length == 8) startDate = startDate.substring(0,4) + "/" + startDate.substring(4,6) + "/" +  startDate.substring(6,8);
    if(endDate.length == 8) endDate = endDate.substring(0,4) + "/" + endDate.substring(4,6) + "/" +  endDate.substring(6,8);
    var t_day = new Date(startDate);
    var f_day = new Date(endDate);
    var days = Math.floor( (f_day-t_day) / 1000 / 60 / 60 / 24 );
    if(days < 0){
        alert("조회 시작일자가 조회 끝일자보다 큽니다. \n날짜를 다시 입력해 주세요.");
        startDateObj.focus();
        return false;
    }else if(days > 365){
        alert("입력한 기간 : " + days + "\n조회 최대기간은 365일 입니다.\n날짜를 다시 입력해 주세요.");
        endDateObj.focus();
        return false;
    }else if(days != 0 && !days){
        alert("날짜가 정상적으로 입력 되지 않았습니다.");
        startDateObj.focus();
        return false;
    }

    return true;
}