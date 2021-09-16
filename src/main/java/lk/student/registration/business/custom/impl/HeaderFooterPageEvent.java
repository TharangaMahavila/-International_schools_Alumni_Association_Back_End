package lk.student.registration.business.custom.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

    Font headerFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("International Schools Alumni Association", headerFont), 300, 800, 0);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("developed by: K.P.T.Mahavila"), 110, 30, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + document.getPageNumber()), 550, 30, 0);
    }

}
