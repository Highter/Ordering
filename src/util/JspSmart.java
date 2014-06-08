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
 * ��д���������� ��1�������ļ��ϴ� ��2�������ļ�����
 * 
 * @author ThinkPad User
 * 
 */
public class JspSmart {
	private SmartUpload mySmartUpload = new SmartUpload();
	private final long FILE_CELL_SIZE = 1024; // ��λ���ֽ�=1k
	private final long FILE_SIZE_MAX = 10 * FILE_CELL_SIZE * FILE_CELL_SIZE;// 1k*1k*40=40M
	private final long TOTAL_SIZE = 30 * FILE_CELL_SIZE * FILE_CELL_SIZE;
	private String path;
	public void fileUpload(PageContext pageContext) throws ServletException,
			IOException {
		System.out.println("fileUpload");
		// (1)��ʼ��SmartUpload����
		mySmartUpload.initialize(pageContext);
		// (2)��������
		// �ϴ��ļ��Ĵ�С����
		mySmartUpload.setMaxFileSize(FILE_SIZE_MAX);
		mySmartUpload.setTotalMaxFileSize(TOTAL_SIZE);
		// �ϴ��ļ����͵�����
		// �趨�����ϴ����ļ���ͨ����չ�����ƣ�,������doc,txt�ļ���
		mySmartUpload.setAllowedFilesList("jpg,png,gif,bmp");
		// �趨��ֹ�ϴ����ļ���ͨ����չ�����ƣ�,��ֹ�ϴ�����exe��չ�����ļ���û����չ�����ļ���
		// mySmartUpload.setDeniedFilesList("exe");

		try {
			// (3)��ʼ�����ļ�
			mySmartUpload.upload();
			System.out.println("upload");
			// (4)�����ϴ����ļ��������ļ����·��
			List<File> files = new ArrayList<File>();
			// ���ϴ������������ļ������������
			for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {
				// ȡ��һ���ļ�
				File myFile = mySmartUpload.getFiles().getFile(i);
				// ֻ��myFile������ļ�����ʱ��ִ�д洢����
				if (!myFile.isMissing()) {
					// ������ļ���webӦ�ó����µ�uploadĿ¼
					myFile.saveAs("/images/" + myFile.getFileName());
					path =  "/images/"+ myFile.getFileName();
					System.out.println("�ɹ��ϴ��ļ���" + "/images/"
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
	 * @param downFile --��Ҫ���ص��ļ�·��
	 * @throws ServletException
	 * @throws IOException
	 */
	public void fileDownload(PageContext pageContext, String downFile)
			throws ServletException, IOException {
		mySmartUpload.initialize(pageContext);
		// �趨contentDispositionΪnull�Խ�ֹ������Զ����ļ���
		// ��֤������Ӻ��������ļ��������趨�������ص��ļ���չ��Ϊtxtʱ��ֱ����������򿪡�
		// �ļ�����Ϊdocʱ����������Զ���word��������չ��Ϊpdfʱ���������acrobat�򿪡�
		mySmartUpload.setContentDisposition(null);
		// �����ļ�
		try {
			mySmartUpload.downloadFile("/WEB-INF/files/" +downFile);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //��� java.lang.IllegalStateException: getOutputStream() has already been called for this response�������		
		/*JspWriter out = pageContext.getOut();
		out.clear(); 
		out = pageContext.pushBody();*/


	}

}
