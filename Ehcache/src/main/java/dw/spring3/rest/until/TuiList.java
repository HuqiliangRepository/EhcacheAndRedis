package dw.spring3.rest.until;

import dw.spring3.rest.bean.t_user_info;

import java.util.List;

/**
 * Created by root on 3/24/16.
 */
public class TuiList {
   private List<t_user_info> tuilist;
    public List<t_user_info> getTuilist(){
        return tuilist;
    }

    public void setTuilist(List<t_user_info> tuilist){
        this.tuilist = tuilist;
    }


}
