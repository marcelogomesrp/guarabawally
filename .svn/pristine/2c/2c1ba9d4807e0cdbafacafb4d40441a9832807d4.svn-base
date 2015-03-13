package br.com.guaraba.wally.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.guaraba.wally.android.R;
import br.com.guaraba.wally.android.util.StringUtils;

public class BuscarActivity extends Activity {

	private Button btnOk;
	private EditText txtProduto;
	private EditText txtValor;

    @Override
    public void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);

        super.setContentView(R.layout.buscar);

        this.init();
    }

	private void init() {

		//btnOk
		this.btnOk = (Button)this.findViewById(R.id.buscar_btnOK);
		this.btnOk.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				BuscarActivity.this.btnOk_onClick();
			}
		});

		this.txtProduto = (EditText)this.findViewById(R.id.buscar_txtProduto);
		this.txtValor = (EditText)this.findViewById(R.id.buscar_txtValorDe);
	}

	private void btnOk_onClick() {

		if(StringUtils.isNullOrEmpty(this.txtProduto.getText().toString())) {

			Toast.makeText(this, "Informe o produto!", Toast.LENGTH_SHORT).show();

		} else {

			final String nomeDoProduto = this.txtProduto.getText().toString();
			final String valorDe = this.txtValor.getText().toString();

			final Bundle bundle = new Bundle();
			bundle.putString(CategoriaListActivity.PRODUTO, nomeDoProduto);
			bundle.putString(CategoriaListActivity.VALOR_ATE, valorDe);

			this.startActivity(new Intent(this, CategoriaListActivity.class).putExtras(bundle));
		}
	}
}