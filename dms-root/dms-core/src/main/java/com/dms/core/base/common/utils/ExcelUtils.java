package com.dms.core.base.common.utils;

import java.io.File;
import java.util.List;

import com.dms.core.base.exception.AppBizException;

/*import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;*/


public class ExcelUtils {
/**
	public static void exportExcel(String filePath, String excelName,
			String[] titleArray, List<List<String>> curDisplayRecs)
			throws AppBizException {
		int row = 0;// excel的行号
		String fileName = filePath + excelName;
		File file = null;
		try {
			file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			throw new AppBizException("E-BASE-104", e, "File export Error");
		}
		// 生成excel表格
		WritableWorkbook writableWorkbook = null;
		try {
			writableWorkbook = Workbook.createWorkbook(file);
			WritableSheet sheet = writableWorkbook.createSheet(excelName, 0);

			// 用于标题
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.WHITE);
			WritableCellFormat wcfTitle = new WritableCellFormat(titleFont);
			wcfTitle.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcfTitle.setAlignment(Alignment.CENTRE);
			wcfTitle.setBackground(Colour.GRAY_50);

			// 列名
			WritableCellFormat wcfTitle1 = new WritableCellFormat(titleFont);
			wcfTitle1.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcfTitle1.setAlignment(Alignment.CENTRE);
			wcfTitle1.setBackground(Colour.GREEN);

			// 用于正文
			WritableFont normalFont = new WritableFont(WritableFont.TAHOMA, 12);
			WritableCellFormat wcfCenter = new WritableCellFormat(normalFont);
			wcfCenter.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
			wcfCenter.setAlignment(Alignment.CENTRE);
			wcfCenter.setWrap(true); // 是否换行

			// 插入案件标题
			sheet.addCell(new Label(0, row, excelName, wcfTitle));
			sheet.mergeCells(0, row, titleArray.length - 1, 0);
			if (null != titleArray && titleArray.length > 0) {
				row++;
			}

			// 添加列名
			for (int i = 0; i < titleArray.length; i++) {
				sheet.setColumnView(i, 20);
				sheet.addCell(new Label(i, row, titleArray[i], wcfTitle1));
			}
			row++;

			// 设置数据
			for (int i = 0; i < curDisplayRecs.size(); i++) {
				// 获取一行
				List<String> onLine = curDisplayRecs.get(i);
				// 添加每条记录的序号
//				sheet.addCell(new Label(0, row, String.valueOf(i + 1),
//						wcfCenter));
				for (int j = 0; j < titleArray.length; j++) {
					String data = "";
					try {
						if (null != onLine.get(j)) {
							data = onLine.get(j).toString();
						}
					} catch (Exception e) {
						throw new AppBizException("E-BASE-104", e,
								"File export Error");
					}
					sheet.addCell(new Label(j, row, data, wcfCenter));
				}
				row++;
			}
			if (null != writableWorkbook) {
				writableWorkbook.write();
				writableWorkbook.close();
			}
		} catch (Exception e) {
			throw new AppBizException("E-BASE-104", e, "File export Error");
		}
	}
	*/
}
