package org.neurogine.services;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.neurogine.commons.Constants;
import org.neurogine.models.Body;
import org.neurogine.models.Header;
import org.neurogine.models.PaymentRecord;
import org.neurogine.models.Trailer;

import java.io.File;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatFileServiceImplementation implements FileService{

    @Override
    public void writeFile() {

        StreamFactory factory = StreamFactory.newInstance();
        // load the xml config of the model class
        factory.load("mapping.xml");

        // use a StreamFactory to create a BeanWriter
        try (BeanWriter writer = factory.createWriter("fileStream", new File(Constants.FILE_NAME))) {
            // write header
            writer.write(new Header("H","FLAT_FILE"));

            // Write Body records
            writer.write(new Body("6813162459", "RM2.00"));
            writer.write(new Body("2039229524", "RM10.00"));
            writer.write(new Body("2299488320", "RM5.00"));

            // Write Trailer
            writer.write(new Trailer("T","FLAT_FILE"));

            writer.flush();
        }

    }

    @Override
    public void generateReport() {
        try {
            // Compile the JRXML template
            JasperReport jasperReport = JasperCompileManager.compileReport("report_template.jrxml");

            // Create a data source. This is where you would retrieve data from your database
            List<PaymentRecord> dataList = new ArrayList<>();
            dataList.add(new PaymentRecord("2024-02-01", "Ref001", 100.00, "Status1", "Remark1"));
            dataList.add(new PaymentRecord("2024-02-02", "Ref002", 100.00, "Status2", "Remark2"));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

            Map<String, Object> parameters = new HashMap<>();

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, "output_report.pdf");

            System.out.println("Report generated successfully!");
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
