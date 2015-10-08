package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.Link;

public class CustomerHomePage extends HomePage {
    
    private class CustomerHomePageUIMap {
        public final ILink ordering;

        public CustomerHomePageUIMap() {
            this.ordering = Link.get()
                    .getByPartialLinkText("Ordering");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private CustomerHomePageUIMap controls;

    public CustomerHomePage() {
        super();
        this.controls = new CustomerHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void orderingClick() {
        this.controls.ordering.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILink getOrdering() {
        return this.controls.ordering;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public OrderingPage gotoOrderingPage() {
        orderingClick();
        return new OrderingPage();
    }    

}
