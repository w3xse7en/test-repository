import com.web.service.impl.ContentImpl;

import java.sql.SQLException;

/**
 * Created by Mew on 2017/7/6.
 */
public class TestContentDto {
    public static void main(String[] args) throws SQLException {
        ContentImpl contentImpl = new ContentImpl();
//        ContentService content = contentImpl.getContent(32);
//        content.setTitle("aaa");
//        contentImpl.updateContent(content);
//        content = contentImpl.getContent(32);
//        System.out.println(content.getTitle());
        contentImpl.deleteContent(29);
    }
}
