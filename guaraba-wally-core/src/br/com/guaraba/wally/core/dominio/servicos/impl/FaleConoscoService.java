package br.com.guaraba.wally.core.dominio.servicos.impl;

import java.sql.Date;
import java.util.List;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.commons.util.EmailUtils;
import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.wally.core.dao.IFaleConoscoDAO;
import br.com.guaraba.wally.core.dao.impl.FaleConoscoDAO;
import br.com.guaraba.wally.core.dominio.entidades.FaleConosco;
import br.com.guaraba.wally.core.dominio.servicos.IFaleConoscoService;

public class FaleConoscoService implements IFaleConoscoService {

	private IFaleConoscoDAO faleConoscoDAO;

	public FaleConoscoService() {
		this.faleConoscoDAO = new FaleConoscoDAO();
	}

	public FaleConosco cadastrar(FaleConosco faleConosco)
			throws ServiceException {
		try {
			faleConosco.setDataCadastro(new Date(System.currentTimeMillis()));
			if (this.podeSerCadastrado(faleConosco)) {
				try {
					faleConosco = this.faleConoscoDAO.salvar(faleConosco);
					EnviaEmail3();
				} catch (Exception e) {
					throw new ServiceException(
							"Ocorreu um erro ao tentar cadastrar a mensagem ",
							e);
				}
			}

		} catch (DataAccessException e) {
			throw new ServiceException(
					"Ocorreu um erro ao tentar cadastrar a mensagem ", e);
		}
		return faleConosco;
	}

	private boolean podeSerCadastrado(FaleConosco faleConosco)
			throws ServiceException {
		ServiceException serviceException = new ServiceException();
		if (!EmailUtils.isEmailValido(faleConosco.getEmail())) {
			serviceException.addMessage(GenericExceptionMessageType.WARNING,
					"É necessário informar um endereço de email válido.");
		}
		if (faleConosco.getNome().isEmpty()) {
			serviceException.addMessage(GenericExceptionMessageType.WARNING,
					"É necessário informar o nome");
		}

		if (faleConosco.getMensagem().isEmpty()) {
			serviceException.addMessage(GenericExceptionMessageType.WARNING,
					"É necessário informar a mensagem");
		}
		if (serviceException.hasMessages()) {

			throw serviceException;
		}
		return true;
	}

	@Override
	public void excluir(FaleConosco faleConosco) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FaleConosco> listarTodos() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EnviarEmail(FaleConosco faleConosco) throws ServiceException {

		// Properties props = System.getProperties();
		// props.put("mail.smtp.host", "smtp.gmail.com");
		// props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.port", 465);
		//
		// Authenticator auth = new Authenticator() {
		// public PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication("mlcalache", "SENHA DO EMAIL");
		// }
		// };
		//
		// Session session = Session.getInstance(props, auth);
		// MimeMessage message = new MimeMessage(session);
		//
		// try {
		//
		// message.setFrom(new InternetAddress("mlcalache@gmail.com",
		// "Matheus de Lara Calache"));
		//
		// message.addRecipient(Message.RecipientType.TO, new InternetAddress(
		// "mlcalache@gmail.com", "Matheus DESTINATARIO"));
		// message.setSubject("ASSUNTO");
		// message.setContent("TEXTO", "text/plain");
		//
		// Transport.send(message);
		//
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (MessagingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void EnviarEmail2(FaleConosco faleConosco) {
		// try {
		// Properties mailProps = new Properties();
		// mailProps.put("mail.smtp.host", "smtp.gmail.com");
		//
		// SimpleAuth auth = null;
		// auth = new SimpleAuth("mlcalache", "SENHA DO EMAIL");
		//
		// mailProps.put("mail.smtp.auth", "true");
		// mailProps.put("mail.user", "mlcalache");
		// mailProps.put("mail.from", "mlcalache@gmail.com");
		// mailProps.put("mail.to", "mlcalache@gmail.com");
		//
		// mailProps.put("mail.smtp.auth", "true");
		// mailProps.put("mail.debug", "true");
		//
		// mailProps.put("mail.smtp.port", 465);
		// mailProps.put("mail.smtp.socketFactory.port", 465);
		// mailProps.put("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		// mailProps.put("mail.smtp.socketFactory.fallback", "false");
		//
		// Session mailSession = Session.getDefaultInstance(mailProps, auth);
		//
		// mailSession.setDebug(true);
		//
		// Message email = new MimeMessage(mailSession);
		//
		// email.setRecipients(Message.RecipientType.TO, InternetAddress
		// .parse("mlcalache@gmail.com"));
		// email.setRecipients(Message.RecipientType.CC, InternetAddress
		// .parse("mlcalache@gmail.com"));
		// email.setRecipients(Message.RecipientType.BCC, InternetAddress
		// .parse("mlcalache@gmail.com"));
		//
		// email.setFrom(new InternetAddress("mlcalache@gmail.com"));
		// email.setSubject("assunto");
		// email.setContent("texto", "text/plain");
		//
		// Transport tr = mailSession.getTransport("smtp");
		// tr.connect("smtp.gmail.com", "mlcalache", "SENHA DO EMAIL");
		// email.saveChanges(); // don't forget this
		// tr.sendMessage(email, email.getAllRecipients());
		// tr.close();
		//
		// } catch (Exception e) {
		// System.out.println(" [E] ERROR: " + e);
		// e.printStackTrace(System.out);
		// }
		// System.out.println(" [#] Email successfully sent");
	}

	public void EnviaEmail3() {
//		SimpleEmail email = new SimpleEmail();
//
//		email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do
//		// e-mail
//
//		try {
//
//			Authenticator auth = new Authenticator() {
//				public PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("mlcalache",
//							"SENHA DO EMAIL");
//				}
//			};
//
//			email.setAuthenticator(auth);
//			email.setSSL(true);
//			email.setSmtpPort(465);
//			email.setSslSmtpPort("465");
//
//			email.addTo("mlcalache@gmail.com", "Matheus de Lara Calache");
//
//			email.setFrom("mlcalache@gmail.com", "Me"); // remetente
//
//			email.setSubject("Mensagem de Teste"); // assunto do e-mail
//
//			email.setMsg("Teste de Email utilizando commons-email"); // conteudo do e-mail
//
//			email.send(); // envia o e-mail destinatário
//
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
