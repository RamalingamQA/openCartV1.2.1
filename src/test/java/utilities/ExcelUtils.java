package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	String path;
	public ExcelUtils(String path){
		this.path=path;
	}
	
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow rw;
	public XSSFCell cl;
	public FileInputStream fi;
	public FileOutputStream fo;
	
	public int rowCount(String path,String sheet) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		int totRow=sh.getLastRowNum();
		wb.close();
		fi.close();
		return totRow;
		}
	
	public int colCount(String path,String sheet,int row) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		rw=sh.getRow(row);
		int cellCount=rw.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		}
	public String getCellData(String path,String sheet,int row,int col) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		rw=sh.getRow(row);
		cl=rw.getCell(col);
		//String data=cl.toString();
		String data;
		try {
		DataFormatter dt=new DataFormatter();
		data=dt.formatCellValue(cl);
		return data;
		}
		catch(Exception e) {
			data="";
			return data;
		}
		finally{
			wb.close();
			fi.close();
		}
		}

}
