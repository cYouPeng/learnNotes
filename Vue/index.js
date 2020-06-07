/*
 *  因浏览器差异，日期字符串分隔符最好统一使用 -和:
 */

/**
 * 将日期对象转为指定格式的字符串
 * @param fmt {string} 指定的格式
 * @param date {object} 日期对象
 * @returns {string}
 */
export function dateObj2DateStr(fmt, date) {
    var o = {
        'M+': date.getMonth() + 1,
        'd+': date.getDate(),
        'h+': date.getHours(),
        'm+': date.getMinutes(),
        's+': date.getSeconds(),
        'q+': Math.floor((date.getMonth() + 3) / 3),
        'S': date.getMilliseconds()
    }
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
    }
    for (var k in o) {
        if (new RegExp('(' + k + ')').test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
        }
    }
    return fmt
}

/**
 * 将日期字符串转为指定格式的字符串
 * @param fmt {string} 指定的格式
 * @param dateStr {string} 日期字符串 只能以 -或: 分隔
 * @returns {string}
 */
export function dateStr2FormatStr(fmt, dateStr) {
    if (!dateStr) return ''
    let newStr = dateStr.replace(/:/g, '-')
    newStr = newStr.replace(/ /g, '-')
    const arr = newStr.split('-')
    const date = new Date(Date.UTC(
        arr[0],
        arr[1] - 1,
        arr[2] || 1,
        arr[3] - 8 || -8,
        arr[4] || 0,
        arr[5] || 0
    ))
    var o = {
        'M+': date.getMonth() + 1,
        'd+': date.getDate(),
        'h+': date.getHours(),
        'm+': date.getMinutes(),
        's+': date.getSeconds(),
        'q+': Math.floor((date.getMonth() + 3) / 3),
        'S': date.getMilliseconds()
    }
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
    }
    for (var k in o) {
        if (new RegExp('(' + k + ')').test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
        }
    }
    return fmt
}