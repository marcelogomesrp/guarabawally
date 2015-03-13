package br.com.guaraba.wally.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.guaraba.wally.android.R;
import br.com.guaraba.wally.android.domain.model.Anuncio;

public class AnuncioActivity extends Activity {

	public static final String ANUNCIO = "AnuncioActivity_ANUNCIO";

	private Anuncio anuncio;

	private EditText txtFornecedor;
	private EditText txtProduto;
	private EditText txtDescricao;
	private EditText txtCategoria;
	private EditText txtValor;
	private Button btnVerMapa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

        super.setContentView(R.layout.anuncio);

        this.init();
	}

	private void init() {

		this.txtFornecedor = (EditText)this.findViewById(R.id.anuncio_txtFornecedor);
		this.txtProduto = (EditText)this.findViewById(R.id.anuncio_txtProduto);
		this.txtDescricao = (EditText)this.findViewById(R.id.anuncio_txtDescricao);
		this.txtCategoria = (EditText)this.findViewById(R.id.anuncio_txtCategoria);
		this.txtValor = (EditText)this.findViewById(R.id.anuncio_txtValor);

		this.btnVerMapa = (Button)this.findViewById(R.id.anuncio_btnVerMapa);
		this.btnVerMapa.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				AnuncioActivity.this.exibirMapa();
			}
		});

    	final Intent intent = this.getIntent();
    	if(intent != null) {

			final Object anuncio = intent.getSerializableExtra(ANUNCIO);
			if(anuncio != null) {

				this.anuncio = (Anuncio) anuncio;
			}
    	}

    	this.preencher();
	}

	private void preencher() {

		this.txtFornecedor.setText(this.anuncio.getProduto().getFornecedor().getNomeFantasia());
		this.txtProduto.setText(this.anuncio.getProduto().getNome());
		this.txtDescricao.setText(this.anuncio.getProduto().getDescricao());
		this.txtCategoria.setText(this.anuncio.getProduto().getCategoria().getNome());
		this.txtValor.setText(this.anuncio.getValorFormatado());
	}

	private void exibirMapa() {

		final Bundle bundle = new Bundle();
		bundle.putSerializable(MapaActivity.ANUNCIO, this.anuncio);

		this.startActivity(new Intent(this, MapaActivity.class).putExtras(bundle));
	}
}