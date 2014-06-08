/*��ҳ������*/
package util;

import java.util.Collection;
/*��Ҫ֪����������
1)�ܼ�¼��	totalRows
2)ÿһҳ��ʾ�ļ�¼��	pageSize
3)��ǰҳ	currPage

������������ݣ�
��ҳ�� totalPages��
	if(totalRows%pageSize==0){
		totalPages = totalRows/pageSize;
	}else{
		totalPages = totalRows/pageSize+1;
	}
��ʼ��startRow��
	startRow = (currPage-1)*pageSize;
������endRow��
	endRow = currPage*pageSize;
��һҳprePage��
	prePage = currPage-1;
��һҳnextPage��
	nextPage = currPage+1;
�Ƿ�����һҳ��
�Ƿ�����һҳ��*/
public class PageController {

  //������
  int totalRowsAmount;
  //ÿҳ����
  int pageSize = 3;
  //��ҳ��
  int totalPages;
  //��ǰҳ��
  int currentPage = 1;
  //��һҳ
  int nextPage;
  //��һҳ
  int previousPage;
  //�Ƿ�����һҳ
  boolean hasNext;
  //�Ƿ�����һҳ
  boolean hasPrevious;

  //��ǰҳ��ʼ��
  int pageStartRow;

  //��ǰҳҪ��ʾ������
  int pageEndRow;
  /**
   * ���캯����
   * @param totalRows ������
   * @param currentPage ��ǰҳ��
   */
  
  public PageController(int totalRows,int currentPage) {
    setPageController(totalRows,currentPage);
  }

  public PageController(int totalRows,int currentPage,int pageSize){
      this.pageSize = pageSize;
      this.setPageController(totalRows,currentPage);
  }

  public void setPageController(int totalRows,int currentPage){

    setTotalRowsAmount(totalRows);
    setCurrentPage(currentPage);
  }

  /**
   * ��������������ҳ����
   * @param i ��������
   */
  private void setTotalRowsAmount(int rows) {

	 //�ܼ�¼��������
    if(rows <0 ){
      totalRowsAmount =  0;
    }else{
      totalRowsAmount = rows;
    }

    //��ҳ��
    if(totalRowsAmount%pageSize==0){
      totalPages = totalRowsAmount / pageSize;
    }else{
      totalPages = totalRowsAmount / pageSize + 1;
    }
  }

  /**
   * ���õ�ǰҳ����
   * @param i
   */
  public void setCurrentPage( int curPage) {

	//���㵱ǰҳ��
    if(curPage <= 0){
      currentPage = 1;
    }else if(curPage > totalPages){
      currentPage = totalPages;
    }else{
      currentPage = curPage;
    }

    //�����Ƿ�����һҳ,�Ƿ�����һҳ
    if(currentPage <= 1){
      hasPrevious = false;
    }else{
      hasPrevious = true;
    }

    if(currentPage >= totalPages){
      hasNext = false;
    }else{
      hasNext = true;
    }

    //������һҳ����һҳ
    nextPage = currentPage + 1;
    previousPage = currentPage - 1;

    //���㿪ʼ�кͽ�����
    if(currentPage != totalPages){
      pageStartRow = (currentPage-1)*pageSize;
      //��¼������0��ʼ
      pageEndRow = currentPage*pageSize;
    }else{
      pageStartRow = (currentPage - 1)*pageSize;
      //��¼������0��ʼ
      pageEndRow = totalRowsAmount - pageStartRow;
    }
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public boolean isHasNext() {
    return hasNext;
  }

  public boolean isHasPrevious() {
    return hasPrevious;
  }

  public int getNextPage() {
    return nextPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public int getPreviousPage() {
    return previousPage;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getTotalRowsAmount() {
    return totalRowsAmount;
  }

  public int getPageStartRow() {
    return pageStartRow;
  }

  public int getPageEndRow(){
      return pageEndRow;
  }

  public String description() {
    String description = "Total:" + this.getTotalRowsAmount() +
        " items " + this.getTotalPages() + " pages,Current page:" +
        this.currentPage + " Previous " + this.hasPrevious +
        " Next:" + this.hasNext +
        " start row:" + this.pageStartRow +
        " end row:" + this.pageEndRow;
    return description;
  }
}




