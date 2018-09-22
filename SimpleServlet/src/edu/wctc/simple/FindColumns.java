package edu.wctc.simple;

public enum FindColumns {
    ACCTNUM, LNAME, FNAME, EMAIL, IPADDR;

    public FindColumns getColumns(String s)
    {
        FindColumns fc = ACCTNUM;
        switch(s)
        {
            case "account_number": return ACCTNUM;
            case "first_name": return FNAME;
            case "last_name": return LNAME;
            case "email": return EMAIL;
            case "ip_address": return IPADDR;
            default: fc = ACCTNUM;
        }
        return fc;
    }
}
