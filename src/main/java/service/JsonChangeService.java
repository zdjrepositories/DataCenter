package service;

import java.util.List;

public interface JsonChangeService {
    public List ToObjectAll(String json, Object object);
    public Object ToObject(String json);
    public String ToJson(String json);

}
