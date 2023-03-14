const date = new Date();
const monthArr = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
const dateCurr = document.querySelector('#dateCurr');
const monthCurr = document.querySelector('#monthCurr');
const yearCurr = document.querySelector('#yearCurr');

dateCurr.textContent = date.getDate();
monthCurr.textContent = monthArr[date.getMonth()];
yearCurr.textContent = date.getFullYear();