package app.utils.exception;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
public class DuplicateIdException extends Exception {

    public DuplicateIdException(String id) {
        super("id is duplicated for "+id);
    }
}
