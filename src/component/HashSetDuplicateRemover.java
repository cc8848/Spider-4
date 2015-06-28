package component;

import clawer.Request;
import clawer.Task;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class HashSetDuplicateRemover implements DuplicateRemover {

    private Set<String> urls = Sets.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

    @Override
    public boolean isDuplicate(Request request, Task task) {
        return !urls.add(getUrl(request));
    }

    protected String getUrl(Request request) {
        return request.getUrl();
    }

    @Override
    public void resetDuplicateCheck(Task task) {
        urls.clear();
    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return urls.size();
    }
    //自己加的
    public int getTotalRequestsCount() {
    	return urls.size();
    }
}