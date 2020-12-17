package com.c.refactoring.menuexamples;

import java.util.Arrays;
import java.util.List;

public class RaghavMenuAccessRefactored {

    public void setAuthorizationsInEachMenus(
            List<MenuItem> menuItems, Role[] roles) {
        if (roles == null)
            return;

        menuItems.stream().forEach(menuItem -> setAccessForMenuItem(roles, menuItem));
    }

    private void setAccessForMenuItem(Role[] roles, MenuItem menuItem) {
        if (doesUserHasTheRole(roles, menuItem
                .getReadAccessRole())) {
            menuItem.setAccess(Constants.READ);
            menuItem.setVisible(true);
        }

        if (doesUserHasTheRole(roles, menuItem
                .getWriteAccessRole())) {
            menuItem.setAccess(Constants.WRITE);
            menuItem.setVisible(true);
        }
    }

    private boolean doesUserHasTheRole(Role[] roles, String writeAccessRole) {
        return Arrays.stream(roles).anyMatch(role -> role.getName().equals(writeAccessRole));
    }

}
