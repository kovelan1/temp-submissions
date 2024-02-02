package org.neurogine.models;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Header {
    @Field(at=0, length=1)
    private String recordType;

    @Field(at=13, length=15)
    private String fileType ;

    public Header(String recordType, String fileType) {
        this.recordType = recordType;
        this.fileType = fileType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
