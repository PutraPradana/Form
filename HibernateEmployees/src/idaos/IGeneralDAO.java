package idaos;

import java.util.List;
/**
 *
 * @author ASUS
 */
public interface IGeneralDAO<T> {
    
   public T getById(Object id);
   public List<T> getData(Object keyword);
   public boolean saveOrDelete(T object, boolean isDelete);
   
}
