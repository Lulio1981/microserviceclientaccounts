package bootcamp.microservices.app.clientaccounts.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class ClientCreditCard implements Serializable {

	private static final long serialVersionUID = 7168216367628318040L;

	private String id;

	private String creditCardNumber;

	private String idClient;

	private Double creditLine;

	private Date expeditionDate;

	private Date expirationDate;

	private Date deadline;

	private Date paymentDate;

	private Double interestRate;

	private Double moratoriumInterestRate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;

	private Integer status;

}
