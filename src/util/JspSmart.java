package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 编写两个方法： （1）处理文件上传 （2）处理文件下载
 * 
 * @author ThinkPad User
 * 
 */
public class JspSmart {
	private SmartUpload mySmartUpload = new SmartUpload();
	private final long FILE_CELL_SIZE = 1024; // 单位是字节=1k
	private final long FILE_SIZE_MAX = 10 * FILE_CELL_SIZE * FILE_CELL_SIZE;// 1k*1k*40=40M
	private final long TOTAL_SIZE = 30 * FILE_CELL_SIZE * FILE_CELL_SIZE;
	private String path;
	public void fileUpload(PageContext pageContext) throws ServletException,
			IOException {
		System.out.println("fileUpload");
		// (1)初始化SmartUpload对象
		mySmartUpload.initialize(pageContext);
		// (2)进行设置
		// 上传文件的大小限制
		mySmartUpload.setMaxFileSize(FILE_SIZE_MAX);
		mySmartUpload.setTotalMaxFileSize(TOTAL_SIZE);
		// 上传文件类型的限制
		// 设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。
		mySmartUpload.setAllowedFilesList("jpg,png,gif,bmp");
		// 设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe扩展名的文件和没有扩展名的文件。
		// mySmartUpload.setDeniedFilesList("exe");

		try {
			// (3)开始接收文件
			mySmartUpload.upload();
			System.out.println("upload");
			// (4)处理上传的文件，设置文件存放路径
			List<File> files = new ArrayList<File>();
			// 对上传到服务器的文件进行逐个处理
			for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {
				// 取出一个文件
				File myFile = mySmartUpload.getFiles().getFile(i);
				// 只有myFile代表的文件存在时才执行存储操作
				if (!myFile.isMissing()) {
					// 保存该文件到web应用程序下的upload目录
					myFile.saveAs("/images/" + myFile.getFileName());
					path =  "/images/"+ myFile.getFileName();
					System.out.println("成功上传文件：" + "/images/"
							+ myFile.getFileName());
					files.add(myFile);
				}
			}
			pageContext.setAttribute("files", files);

		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

	}
	public String getPath()
	{
		return path;
	}
	
	public SmartUpload getMySmartUpload() {
		return mySmartUpload;
	}

	public void setMySmartUpload(SmartUpload mySmartUpload) {
		this.mySmartUpload = mySmartUpload;
	}

	/**
	 * 
	 * @param pageContext
	 * @param downFile --需要下载的文件路径
	 * @throws ServletException
	 * @throws IOException
	 */
	public void fileDownload(PageContext pageContext, String downFile)
			throws ServletException, IOException {
		mySmartUpload.initialize(pageContext);
		// 设定contentDisposition为null以禁止浏览器自动打开文件，
		// 保证点击链接后是下载文件。若不设定，则下载的文件扩展名为txt时，直接在浏览器打开。
		// 文件类型为doc时，浏览器将自动用word打开它。扩展名为pdf时浏览器将用acrobat打开。
		mySmartUpload.setContentDisposition(null);
		// 下载文件
		try {
			mySmartUpload.downloadFile("/WEB-INF/files/" +downFile);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //解决 java.lang.IllegalStateException: getOutputStream() has already been called for this response这个问题		
		/*JspWriter out = pageContext.getOut();
		out.clear(); 
		out = pageContext.pushBody();*/


	}

}
