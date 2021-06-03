let appname = '';
let debug = false;
let domain = debug == true ? 'localhost.charlesproxy.com:8080' : 'localhost:8080';
let baseUrl = 'http://' + domain + '' + appname;
export {
    baseUrl
}