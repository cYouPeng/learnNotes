
// let xlsx = require('xlsx')
import * as xlsx from 'xlsx'
import FileSaver from 'file-saver'
/**
     * 导出Excel
     * @param json   要导出的json数据
     * @param name   要导出的文件名
     * @param type   要导出的数据类型
     * @constructor
     */
export function josn2Excel(json, name = 'data', type = 'application/octet-stream') {
    let wb = { SheetNames: [], Sheets: {}, Props: {} }
    if (!Array.isArray(json)) json = [json]
    json.forEach(item => {
        wb.SheetNames.push(item.sheet_name)
        wb.Sheets[item.sheet_name] = xlsx.utils.json_to_sheet(item.sheet_values, item.sheet_options)
    })

    const wopts = { bookType: 'xlsx', bookSST: false, type: 'binary' }
    let blob = new Blob([s2ab(xlsx.write(wb, wopts))], { type })
    let link = document.createElement('a')
    document.body.appendChild(link)
    link.style.display = 'none'
    link.href = window.URL.createObjectURL(blob)
    link.download = `${name}.xlsx`
    link.click()
    // 释放资源
    setTimeout(() => {
        URL.revokeObjectURL(link.href)
    }, 100)

    function s2ab(s) {
        if (typeof ArrayBuffer !== 'undefined') {
            const buf = new ArrayBuffer(s.length)
            const view = new Uint8Array(buf)
            for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF
            return buf
        } else {
            const buf = new Array(s.length)
            for (let i = 0; i !== s.length; ++i) buf[i] = s.charCodeAt(i) & 0xFF
            return buf
        }
    }
}
/**
 * 通过 Table 导出 Excel
 * */
export function ExportTableToExcel(id, title) {
    /* generate workbook object from table */
    //  判断要导出的节点中是否有fixed的表格，如果有，转换excel时先将该dom移除，然后append回去，
    let fix = document.querySelector('.el-table__fixed')
    let wb
    if (fix) {
        wb = xlsx.utils.table_to_book(document.querySelector('#' + id).removeChild(fix))
        document.querySelector('#' + id).appendChild(fix)
    } else {
        wb = xlsx.utils.table_to_book(document.querySelector('#' + id))
    }

    // 网上wb = xlsx.utils.table_to_book(document.querySelector('#'+id));直接这样写，如果存在固定列，导出的excel表格会重复两遍

    /* get binary string as output */
    let wbout = xlsx.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
    try {
        FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), title + '.xlsx')
    } catch (e) {
        if (typeof console !== 'undefined') console.log(e, wbout)
    }
    return wbout
}