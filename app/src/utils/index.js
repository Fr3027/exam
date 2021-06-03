function getdate() {
    var today = new Date();
    var date =
        today.getFullYear() +
        "-" +
        (today.getMonth() + 1) +
        "-" +
        today.getDate();
    var time =
        today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date + " " + time;
    return dateTime;
}

function formatNumber(n) {
    const str = n.toString()
    return str[1] ? str : `0${str}`
}

export function formatTime(date) {
    const year = date.getFullYear()
    const month = date.getMonth() + 1
    const day = date.getDate()

    const hour = date.getHours()
    const minute = date.getMinutes()
    const second = date.getSeconds()

    const t1 = [year, month, day].map(formatNumber).join('/')
    const t2 = [hour, minute, second].map(formatNumber).join(':')

    return `${t1} ${t2}`
}
import { baseUrl } from "@/config";
import fly from "@/flyjs";

function fetchList(url, params = {}, search = undefined) {
    return new Promise((resolve, reject) => {
        fly
            .get(baseUrl + url, params)
            .then(response => {
                var items = response.data;
                if (search) {
                    items = items.filter(item => {
                        return Object.values(item)
                            .join(",")
                            .toLowerCase()
                            .includes(search.trim().toLowerCase());
                    });
                }
                var total = items.length;
                resolve({
                    items,
                    total
                });
            });
    });
}
export {
    formatNumber,
    getdate,
    fetchList
}